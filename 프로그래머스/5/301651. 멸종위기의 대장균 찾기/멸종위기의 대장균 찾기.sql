-- 코드를 작성해주세요
WITH RECURSIVE ecoli AS (
    -- Anchor: 루트 노드 찾기
    SELECT id, parent_id, 1 AS depth
    FROM ecoli_data
    WHERE parent_id IS NULL
    UNION ALL
    -- Recursive: 자식 노드를 탐색
    SELECT ed2.id, ed2.parent_id, ed1.depth + 1
    FROM ecoli_data ed2
    JOIN ecoli ed1 ON ed2.parent_id = ed1.id
)
SELECT 
    COUNT(e.id) AS `count`,
    e.depth AS `generation`
FROM ecoli e
LEFT JOIN ecoli children ON e.id = children.parent_id
WHERE children.id IS NULL
GROUP BY e.depth
ORDER BY e.depth