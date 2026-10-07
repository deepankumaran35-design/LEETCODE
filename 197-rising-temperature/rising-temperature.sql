WITH RankedWeather AS (
    SELECT 
        id,
        recordDate,
        temperature,
        LAG(recordDate) OVER (ORDER BY recordDate) AS prev_date,
        LAG(temperature) OVER (ORDER BY recordDate) AS prev_temp
    FROM Weather
)
SELECT id
FROM RankedWeather
WHERE DATEDIFF(recordDate, prev_date) = 1
  AND temperature > prev_temp;