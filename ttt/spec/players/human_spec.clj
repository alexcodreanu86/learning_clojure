(ns players.human-spec
  (:require [speclj.core   :refer :all]
            [players.human :refer :all]))

(describe "next-human-move"
  (around [it]
    (with-out-str (it)))

  (it "returns a valid move when the board is empty"
    (should= true
             (with-in-str "7" (contains? (vec (range 9))
                        (next-human-move {})))))

  (it "returns only valid input"
     (should= 8
              (with-in-str "6\n10\n8"
                (next-human-move
                  {0 "X" 1 "O" 2 "X" 3 "O" 4 "O" 5 "X" 6 "O" 7 "O"})))))
