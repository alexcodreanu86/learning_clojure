(ns fizzbuzz.core-spec
  (:require [speclj.core :refer :all]
            [fizzbuzz.core :refer :all]))
(def fizzbuzz-results { 1  1
                        2  2
                        3  "fizz"
                        4  4
                        5  "buzz"
                        6  "fizz"
                        9  "fizz"
                        10 "buzz"
                        15 "fizzbuzz"
                        30 "fizzbuzz"
                       })

(defn assert-fizzbuzz [argument result]
  (it (str "returns " result " for " argument)
    (should= result (fizzbuzz argument))))

(describe "fizzbuzz"
  (for [[argument result] fizzbuzz-results]
    (assert-fizzbuzz argument result)))
