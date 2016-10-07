(set-env!
  :dependencies '[[javelin "3.8.1"]
                  [adzerk/boot-cljs "1.7.228-1" :scope "test"]
                  [org.clojure/clojurescript "1.9.229"]
                  [pandeiro/boot-http "0.7.3" :scope "test"]]
  :source-paths #{"src"}
  :resource-paths #{"resources"})

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[pandeiro.boot-http :refer [serve]])

(deftask build []
  (comp
    (serve :port 5000)
    (watch)
    (cljs)))
