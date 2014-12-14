(ns cljs-nodejs-coreasync-bootstrap.hello
  (:require [cljs.nodejs :as nodejs] )

  (:require-macros [cav.cljs.asyncflow :refer [async]]))

(def che (nodejs/require "./w"))

(defn ^:export do-async []
  (async
    (let [a (che 1 ...)
          b (che 2 ...)
          cs-in (map #(che % ...) (range 5 9))
          [ & cs] !!cs-in]
      (str "a = " !a ", b = " !b ", cs = " cs)
      )))

(defn -main [& args]
  (print (do-async))
  )


(set! *main-cli-fn* -main)
