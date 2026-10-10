# Write your MySQL query statement below
WITH RankedReviews AS (
    SELECT 
        employee_id,
        review_date,
        rating,
        ROW_NUMBER() OVER (PARTITION BY employee_id ORDER BY review_date DESC) as rn
    FROM 
        performance_reviews
),
LastThree AS (
    SELECT 
        r1.employee_id,
        r1.rating AS latest_rating,
        r3.rating AS earliest_rating
    FROM 
        RankedReviews r1
    JOIN 
        RankedReviews r2 ON r1.employee_id = r2.employee_id AND r2.rn = 2
    JOIN 
        RankedReviews r3 ON r1.employee_id = r3.employee_id AND r3.rn = 3
    WHERE 
        r1.rn = 1 
        AND r1.rating > r2.rating 
        AND r2.rating > r3.rating
)
SELECT 
    e.employee_id,
    e.name,
    (lt.latest_rating - lt.earliest_rating) AS improvement_score
FROM 
    LastThree lt
JOIN 
    employees e ON lt.employee_id = e.employee_id
ORDER BY 
    improvement_score DESC,
    e.name ASC;