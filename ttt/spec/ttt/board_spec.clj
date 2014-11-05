(ns ttt.board-spec
  (:require [speclj.core :refer :all]
            [ttt.board   :refer :all]))
(describe "valid-moves"
  (it "returns all the valid moves when the board is empty"
      (should= '(0 1 2 3 4 5 6 7 8) (valid-moves {})))

  (it "returns just the valid moves of a board"
      (should= '(0 2 5 6) (valid-moves {1 "X" 3 "O" 4 "X" 7 "X" 8 "O"}))))

(describe "valid-move?"
  (it "returns true if move is greater than -1 and smaller than 9"
      (should (valid-move? 7)))

  (it "returns false if move is greater than 8"
      (should-not (valid-move? 9)))

  (it "returns false if move is smaller than 0"
      (should-not (valid-move? -9))))

(describe "is-game-over?"
  (it "renturns false if nobody won and there are moves left"
    (should-not (is-game-over? {})))

  (it "renturns true if board is full"
    (should (is-game-over? {0 "X" 1 "O" 2 "X"
                            3 "O" 4 "X" 5 "O"
                            6 "O" 7 "X" 8 "O"})))
  (it "returns false if a player not won and there is one more move left"
    (should-not (is-game-over? {0 "X" 1 "O" 2 "X"
                                3 "O" 4 "X" 5 "O"
                                6 "O" 7 "X" }))))
(describe "has-winner?"
  (def winning-boards '({0 "X" 1 "X" 2 "X"}
                        {3 "O" 4 "O" 5 "O"}
                        {6 "O" 7 "O" 8 "O"}
                        {0 "X" 3 "X" 6 "X"}
                        {1 "X" 4 "X" 7 "X"}
                        {2 "O" 5 "O" 8 "O"}
                        {0 "O" 4 "O" 8 "O"}
                        {2 "X" 4 "X" 6 "X"}))
  (defn assert-board-has-winner [board]
    (should (has-winner? board)))

  (it "has-winner? returns false when there is no winner"
    (should-not (has-winner? {0 "X" 1 "O" 2 "X"
                              3 "O" 4 "X" 5 "O"
                              6 "O" 7 "X" })))

  (it "has-winner? returns true when there is a winner"
    (loop [index 0]
      (if (< index (count winning-boards))
        (do
          (assert-board-has-winner (nth winning-boards index))
          (recur (+ index 1)))))))

(describe "get-winner"
  (it "returns X when X is the winner"
      (should= "X" (get-winner {0 "X" 1 "X" 2 "X"})))

  (it "returns O when O is the winner"
      (should= "O" (get-winner {0 "O" 3 "O" 6 "O"}))))
