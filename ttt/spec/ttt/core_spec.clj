(ns ttt.core-spec
  (:require [speclj.core :refer :all]
            [ttt.core :refer :all]
            [ttt.display :refer [display-end-of-game]]
            [players.human :refer [next-human-move]]
            [players.ai    :refer [next-ai-move]]))

(defn reset-players []
  (dosync (ref-set player1 nil) (ref-set player2 nil)))

(def draw-board {0 "X" 1 "O" 2 "X"
                 3 "O" 4 "O" 5 "X"
                 6 "O" 7 "X" 8 "O"})

(describe "setup-game"
  (before (reset-players))
  (around [it] (with-out-str (it)))

  (it "sets up Human vs AI when input is 1"
    (with-in-str "1" (setup-game))
    (should= :human @player1)
    (should= :ai @player2))

  (it "sets up ai vs human when input is 2"
    (with-in-str "2" (setup-game))
    (should= :ai @player1)
    (should= :human @player2))

  (it "sets up human vs human when input is 3"
    (with-in-str "3" (setup-game))
    (should= :human @player1)
    (should= :human @player2))

  (it "asks display for input again if input is not valid"
    (with-in-str "4\n1" (setup-game))
    (should= :human @player1)
    (should= :ai @player2)))

(describe "human-player?"
  (around [it] (with-out-str (it)))

  (it "returns true if player is human"
    (with-in-str "1" (setup-game))
    (should (human-player? player1))
      )
)

(describe "start-game"
  (before (reset-players))
  (around [it] (with-out-str (it)))

  (it "sets up the game"
    (with-in-str "3"
      (start-game draw-board))
    (should= :human @player1)
    (should= :human @player2))

  (it "displays game ended when it is a draw"
    (should-invoke display-end-of-game {:with [nil]}
                   (with-in-str "3" (start-game draw-board))))

  (it "displays game ended with X when X wins"
      (def winning-board {0 "X" 1 "O" 2 "X"
                          3 "O" 4 "O" 5 "X"
                          7 "X" })
      (should-invoke display-end-of-game {:with ["X"]}
                    (with-in-str "3\n8" (start-game winning-board))))

  (it "displays game ended with O when O wins"
      (def winning-board {0 "X" 1 "O" 2 "X"
                          3 "O" 4 "O" 5 "X" })
      (should-invoke display-end-of-game {:with ["O"]}
                    (with-in-str "3\n6\n7" (start-game winning-board)))))

(describe "player-move"
  (before (reset-players))
  (around [it] (with-out-str (it)))

  (it "gets the player human move if player is human"
      (with-in-str "3" (setup-game))
      (should-invoke next-human-move {:with [{}]}  (player-move player1 {})))

  (it "gets the player ai move if player is ai"
      (with-in-str "2" (setup-game))
      (should-invoke next-ai-move {:with [{}]} (player-move player1 {})))
)
