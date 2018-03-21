(defproject hello-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; :repositories [["qt" "http://uqbar-wiki.org/mvn/releases/"]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.cli "0.3.5"]
                 ]
  :main hello-clojure.core
  :aot [hello-clojure.core])

