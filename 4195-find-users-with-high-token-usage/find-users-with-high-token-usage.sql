# Write your MySQL query statement below
SELECT 
    p1.user_id, 
    COUNT(p1.prompt) AS prompt_count, 
    ROUND(AVG(p1.tokens), 2) AS avg_tokens
FROM 
    prompts p1
GROUP BY 
    p1.user_id
HAVING 
    COUNT(p1.prompt) >= 3 
    AND MAX(p1.tokens) > AVG(p1.tokens)
ORDER BY 
    avg_tokens DESC, 
    p1.user_id ASC;