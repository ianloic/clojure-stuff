(ns ianloic.parse)


(defn lazy-stream [s]
  (let [curr-char (. s read)]
    (lazy-cons curr-char 
      (when (not= -1 curr-char)
            (lazy-stream s)))))



(def byte-stream (filter (fn [b] (> b 0)) (lazy-stream (java.io.FileReader. "parse.clj"))))

(def character-stream (map char byte-stream))



(println (str character-stream))
