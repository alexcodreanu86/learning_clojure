(ns players.ai-spec
  (:require [speclj.core :refer :all]
            [players.ai  :refer :all]))

(describe "next-ai-move"
  (it "returns the only empty move on the board when there is only one left"
      (def board {0 "X" 1 "O" 2 "X"
                  3 "O" 4 "O" 5 "X"
                        7 "X" 8 "O" })
      (should= 6 (next-ai-move board "X")))

  (it "returns a winning move when there is a win available"
      (def board {0 "X" 1 "O" 2 "X"
                  3 "O" 4 "O" 5 "X"
                        7 "X"      })
      (should= 8 (next-ai-move board "X")))

  (it "returns a defending move to prevent opponent from winning"
      (def board {0 "X" 1 "X" 2 "O" 4 "O"  })
      (should= 6 (next-ai-move board "X")))

  (it "starts a fork when it has the opportunity"
      (def board {0 "X" 1 "O" 4 "O" 7 "X"})
      (should= 6 (next-ai-move board "X"))))

(describe "get-board-score"
  (it "returns 10 if the board is a winning board for the ai"
      (def board {0 "X" 1 "O" 2 "X"
                  3 "O" 4 "O" 5 "X"
                        7 "X" })
      (should= 10 (get-board-score board "X" "X" 8)))


  (it "returns -10 if the board is a loosing board for the ai"
      (def board {0 "X" 1 "O" 2 "X"
                  3 "O" 4 "O" 5 "X"
                        7 "X" })
      (should= -10 (get-board-score board "O" "X" 8)))

  (it "returns 0 if the board is a draw"
      (def board {0 "X" 1 "O" 2 "X"
                  3 "O" 4 "O" 5 "X"
                  6 "X" 7 "X" })
      (should= 0 (get-board-score board "O" "O" 8))))
