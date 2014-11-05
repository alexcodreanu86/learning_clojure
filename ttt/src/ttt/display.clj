(ns ttt.display
  (:require [ttt.templates :refer [render-board]]))

(defn get-user-input []
  (println "Enter your next move:")
  (read-line))

(defn display-end-of-game [winner]
  (if (nil? winner)
    (println "Game ended!!! It's a draw.")
    (println (str winner " has won!"))))

(defn get-game-type []
  (println "Please choose the type of game that you want to play:\n[1] Human: X; AI: O\n[2] AI: X; Human: O\n[3] Human: X; Human: O")
  (read-line))

(defn display-board [board]
  (println (render-board board)))
