-- 코드를 작성해주세요
select ed1.id, sum(case when ed2.parent_id is not null then 1 else 0 end) as `child_count`
from ecoli_data ed1
left join ecoli_data ed2 on ed1.id = ed2.parent_id
group by ed1.id