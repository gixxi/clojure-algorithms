(ns org.lambdaroyal.clojurealgorithms.approximation.t-genetic
  (:use midje.sweet)
  (:require [org.lambdaroyal.clojurealgorithms.approximation.genetic])
  (:import [org.lambdaroyal.clojurealgorithms.approximation.genetic TGa]))

(def domain
  "abstract domain definition"
  (repeatedly 10 #(range 2)))

(defn fitness-fn [population-element]
  (apply + population-element))

;;check with fitness function that just sums up the components, 0 would be the value with the best fitness
(fact (second @(TGa. nil domain 10 #(apply + %) 20 0.1 0.15 nil)) => #(< % 3))

