(ns hello-clojure.sign)

;; https://www.quickprogrammingtips.com/java/how-to-create-sha256-rsa-signature-using-java.html
;; http://worace.works/2016/06/05/rsa-cryptography-in-clojure/

(require '[clojure.string :as string])
;; (require '[clj-crypto.core :as crypto])

(import (java.security Signature KeyFactory)
        (java.security.spec PKCS8EncodedKeySpec)
        (java.nio.file Paths)
        (java.util Base64)
        (java.io File FileReader)
        'org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter
        'org.bouncycastle.openssl.PEMParser)

;; PKCS#1 and PKCS
(java.security.Security/addProvider (org.bouncycastle.jce.provider.BouncyCastleProvider.))

(defn- path-join
  ([first] first)
  ([first & rest] (.toString (Paths/get first (into-array rest)))))

(defn- get-private-key-base64 [file]
  (-> (slurp file)
      (string/replace "-----BEGIN RSA PRIVATE KEY-----" "")
      (string/replace "-----END RSA PRIVATE KEY-----" "")
      (string/replace "\n" "")))

(defn- get-private-key-old
  ([] (get-private-key-old (path-join (System/getenv "HOME") ".ssh" "id_rsa")))
  ([file]
   (. (Base64/getDecoder)
      (decode (get-private-key-base64 file)))))

(defn- get-private-key
  ([] (get-private-key (path-join (System/getenv "HOME") ".ssh" "id_rsa")))
  ([file] (let [parser (PEMParser. (FileReader. (File. file)))
                kconv (doto (JcaPEMKeyConverter.) (.setProvider "BC"))]
            (let [keypair (.getKeyPair kconv (.readObject parser))]
              (.. keypair
                  (getPrivate)
                  (getEncoded))))))

(defn- sign [input]
 (let [kf (KeyFactory/getInstance "RSA")
        sp (PKCS8EncodedKeySpec. (get-private-key))]
    (let [sg (doto (Signature/getInstance "SHA256withRSA")
               (.initSign (.generatePrivate kf sp))
               (.update (.getBytes input "UTF-8")))]
      (.sign sg))))

(defn sha256-rsa [input]
  (.encodeToString (Base64/getEncoder) (sign input)))
  
