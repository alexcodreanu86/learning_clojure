(ns ttt.display-spec
  (:require [speclj.core :refer :all]
            [ttt.display :refer :all]))

(describe "get-user-input"
  (around [it] (with-out-str (it)))

  (it "returns the user input"
      (should= "8" (with-in-str "8" (get-user-input))))
  (it "prompts the user for input"
      (should= "Enter your next move:\n"
               (with-out-str (with-in-str "8" (get-user-input))))))

(describe "display-end-of-game"
  (it "displays winner when a winner is provided"
      (should= "X has won!\n"
               (with-out-str (display-end-of-game "X"))))

  (it "displays draw when winner is nil"
      (should= "Game ended!!! It's a draw.\n"
               (with-out-str (display-end-of-game nil)))))

(describe "get-game-type"
  (around [it] (with-out-str (it)))

  (it "asks the player choose a game type"
      (should= "Please choose the type of game that you want to play:\n[1] Human: X; AI: O\n[2] AI: X; Human: O\n[3] Human: X; Human: O\n"
               (with-out-str (with-in-str "2" (get-game-type)))))
  (it "returns the player input"
      (should= "8" (with-in-str "8" (get-game-type)))))

(describe "display-board"
  (it "displays the board"
    (def board {0 "X" 2 "O" 4 "X" 8 "O"})
     (should= "X| |O\n-----\n |X| \n-----\n | |O\n"
              (with-out-str (display-board board))))
)
