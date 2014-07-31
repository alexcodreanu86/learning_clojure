(ns fizzbuzz.core-spec
  (:require [speclj.core :refer :all]
            [fizzbuzz.core :refer :all]))
(def fizzbuzz-results {1  1
                       2  2
                       3  "fizz"
                       5  "buzz"
                       6  "fizz"
                       9  "fizz"
                       10 "buzz"
                       15 "fizzbuzz"})
(defn assert-fizzbuzz [input output]
    (it (str "returns " output " for " input)
      (should= output (fizzbuzz input))))

(describe "fizzbuzz"
  (for [[input output] fizzbuzz-results]
    (assert-fizzbuzz input output)))
