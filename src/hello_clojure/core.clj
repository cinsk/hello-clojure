(ns hello-clojure.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))
            

(def cli-options
  [["-o" "--output FILE"  "Output to FILE instead of stdin"
    :default "-"]
   [nil "--help"]
   [nil "--version"]])


(defn -main [& args]
  (let [{:keys [options arguments]} (parse-opts args cli-options)]
    (println (format "# output: %s" (:output options)))
    (println (format "# arguments: %s" arguments))
    (println "hello, world!"))
    )
  


