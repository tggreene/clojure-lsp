(ns clojure-lsp.refactor.transform.coll
  (:require
    [rewrite-clj.zip :as z]))

(defn find-other-colls [zloc]
  (let [sexpr (z/sexpr zloc)]
    (cond
      (map? sexpr) [:vector :set :list]
      (vector? sexpr) [:set :list :map]
      (set? sexpr) [:list :map :vector]
      (list? sexpr) [:map :vector :set])))
