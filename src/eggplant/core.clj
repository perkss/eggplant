(ns eggplant.core
  (:require [clojure.test :refer :all]))

;; TODO Multiple parameters allowed
(defmacro given [x]
  (var-get (def var x)))

(defn when-we-process [test-fn & data]
  (apply test-fn data))

;; TODO need to make this equal work for all types
(defn then-we-expect [expected actual]
  (is (true? (= expected actual))))

(defn then-we-do-not-expect [expected actual]
  (is (false? (= expected actual))))

(defmacro defspec
  ^{:safe true}
  [& args] `(deftest ~@args))

;; TODO define a defSpecification fn that refers to defTest



