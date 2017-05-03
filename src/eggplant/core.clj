(ns eggplant.core
  (:require [clojure.test :refer :all]))

;; TODO Multiple parameters allowed
(defn given [x]
  (var-get (def var x)))

(defn when-we-process [testFn & data]
  (apply testFn data))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (= expected actual))


