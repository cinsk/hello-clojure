(defproject hello-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; :repositories [["qt" "http://uqbar-wiki.org/mvn/releases/"]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.cli "0.3.5"]
                 [clj-http "3.8.0"]
                 [clj-crypto "1.0.2"]
                 [org.bouncycastle/bcpkix-jdk15on "1.59"]
                 [org.bouncycastle/bcprov-jdk15on "1.59"]
                 [com.joyent.triton/java-triton-client "LATEST"]
                 [org.slf4j/slf4j-api "1.7.25"]
                 [org.slf4j/slf4j-simple "1.7.25"]
                 ;; [com.trolltech.qt/qtjambi "4.8.5"]
                 ]
  :main hello-clojure.core)

