-- 코드를 작성해주세요
select
    ed3.id
from (
    select
        ed2.id
    from (
        select
            ed1.id
        from ecoli_data ed1
        where ed1.parent_id is null
    ) as A
    join ecoli_data ed2 on ed2.parent_id = A.id
) as B
join ecoli_data ed3 on ed3.parent_id = B.id