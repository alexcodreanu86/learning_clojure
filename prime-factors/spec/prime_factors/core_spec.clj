(ns prime-factors.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors.core :refer :all]))

(describe "prime-factors"
  (it "returns [] for 1"
    (should= [] (prime-factors 1)))
  (it "returns [2] for 2"
    (should= [2](prime-factors 2)))
  (it "returns [3] for 3"
    (should= [3] (prime-factors 3)))
  (it "returns [2 2] for 4"
    (should= [2 2] (prime-factors 4)))
  (it "returns [3 3] for 9"
    (should= [3 3] (prime-factors 9)))
  (it "returns [2 3 5 7] for 210"
    (should= [2 3 5 7] (prime-factors 210))))
