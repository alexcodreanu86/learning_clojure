(ns ttt.controller
  (:require [ttt.display :refer :all]
            [ttt.board   :refer :all]
            [players.human :refer [next-human-move]]
            [players.ai    :refer [next-ai-move]]))

(def player1 (ref nil))
(def player2 (ref nil))

(defn setup-players [player-1 player-2]
  (dosync (ref-set player1 player-1) (ref-set player2 player-2)))

(defn setup-game []
  (let [game-type (get-game-type)]
    (cond (= "1" game-type) (setup-players :human :ai)
          (= "2" game-type) (setup-players :ai :human)
          (= "3" game-type) (setup-players :human :human)
          :else (setup-game))))

(defn human-player? [player]
  (= @player :human))

(defn player-symbol [player]
  (if (= player1 player) "X" "O"))

(defn next-player [current-player]
  (if (= current-player player1)
    player2
    player1))

(defn player-move [player board]
  (if (human-player? player)
      (next-human-move board)
      (next-ai-move    board (player-symbol player))))

(defn next-board-state [board player]
  (assoc board
         (player-move player board) (player-symbol player)))

(defn next-move [player board]
  (loop [current-player player
         current-board board]
    (do (display-board current-board)
        (if (is-game-over? current-board)
          (display-end-of-game (get-winner current-board))
          (do (display-player-turn (player-symbol current-player))
              (recur (next-player current-player)
                     (next-board-state current-board current-player)))))))

(defn start-game [board]
  (setup-game)
  (next-move player1 board))
