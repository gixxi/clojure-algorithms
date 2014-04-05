(defproject org.lambdaroyal/clojure-algorithms "0.1-SNAPSHOT"
  :description "LambdaRoyal Clojure Algorithms"
  :url "https://github.com/gixxi/clojure-algorithms"
  :license {:name "LGPL v3"
            :url "http://www.gnu.org/licenses/lgpl.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.nrepl "0.2.3"]
                 [org.lambdaroyal/clojure-util "1.0-SNAPSHOT"]
                 [lein-light-nrepl "0.0.13"]]
  :profiles {:dev 
             {:dependencies [[midje "1.6.3"]]
              :plugins [[lein-midje "3.1.3"]]}}
  :repl-options {:nrepl-middleware [lighttable.nrepl.handler/lighttable-ops]})

