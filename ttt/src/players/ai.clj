(ns players.ai
  (:require [ttt.board :refer :all]))

(defn score-end-board [board ai-symbol]
  (let [winner-symbol (get-winner board)]
    (cond (= ai-symbol winner-symbol) 10
          (nil? winner-symbol) 0
          :else -10)))

(defn next-player-symbol [current-player]
  (if (= current-player "X") "O" "X"))

(defn get-next-round-score [ai-symbol player-moving scores]
  (if (= ai-symbol player-moving)
    (apply max scores)
    (apply min scores)))

(defn get-board-score [board ai-symbol player-moving move]
  (let [next-board (assoc board move player-moving)]
  (if (is-game-over? next-board)
    (score-end-board next-board ai-symbol)
    (get-next-round-score
      ai-symbol
      (next-player-symbol player-moving)
      (map (fn [move] (get-board-score next-board
                                       ai-symbol
                                       (next-player-symbol player-moving)
                                       move))
          (valid-moves next-board))))))

(defn get-scores-for-moves [board ai-symbol]
  (let [possible-moves (valid-moves board)]
    (into {} (map
               (fn [move]
                 [(get-board-score board ai-symbol ai-symbol move)
                  move])
               possible-moves))))

(defn next-ai-move [board ai-symbol]
  (let [scores-for-moves (get-scores-for-moves board ai-symbol)]
    (get scores-for-moves (apply max (filter identity (keys scores-for-moves))))))

