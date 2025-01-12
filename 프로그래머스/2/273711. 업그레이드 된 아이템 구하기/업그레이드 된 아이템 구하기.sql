SELECT 
    i.item_id,
    i.item_name,
    i.rarity
FROM 
    item_tree t
JOIN 
    item_info p
    on t.parent_item_id = p.item_id
join
    item_info i
    on t.item_id = i.item_id
where
    p.rarity = 'RARE'
order by i.item_id desc