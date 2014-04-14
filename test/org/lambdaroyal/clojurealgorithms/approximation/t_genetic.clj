(ns org.lambdaroyal.clojurealgorithms.approximation.t-genetic
  (:use midje.sweet)
  (:require [org.lambdaroyal.clojurealgorithms.approximation.genetic])
  (:import [org.lambdaroyal.clojurealgorithms.approximation.genetic TGa]))

(def domain
  "abstract domain definition"
  (repeatedly 10 #(range 2)))

(defn fitness-fn [population-element]
  (apply + population-element))

(defmacro bench
    "Times the execution of forms, discarding their output and returning
    a long in nanoseconds."
    ([& forms]
         `(let [start# (System/nanoTime)]
                   ~@forms
                   (- (System/nanoTime) start#))))

;;check with fitness function that just sums up the components, 0 would be the value with the best fitness
(fact (second @(TGa. domain 10 #(apply + %) 20 0.1 0.15 nil {})) => #(< % 3))

;;check with fitness function that just sums up the components, 0 would be the value with the best fitness (print verbose values)
(fact (second @(TGa. domain 10 #(apply + %) 20 0.1 0.15 nil {:verbose true})) => #(< % 3))

;;check that we run faster when terminating the algorithms as soon as no improvement is achieved over 5 consecutive rounds
(let
  [t1 (bench @(TGa. domain 10 #(apply + %) 120 0.1 0.15 nil {:terminating-condition 5}))
   t2 (bench @(TGa. domain 10 #(apply + %) 120 0.1 0.15 nil {}))]
  (fact (< t1 t2) => true))
