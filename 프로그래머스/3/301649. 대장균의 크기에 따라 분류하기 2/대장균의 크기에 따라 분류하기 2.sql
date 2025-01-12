-- 코드를 작성해주세요
select
    A.id,
    case
        when A.ntile = 1
        then 'CRITICAL'
        when A.ntile = 2
        then 'HIGH'
        when A.ntile = 3
        then 'MEDIUM'
        else 'LOW'
    end as `colony_name`
from (
    select
        ed1.id,
        ntile(4) over (order by ed1.size_of_colony desc) as `ntile`
    from ecoli_data ed1
    left join (
        select
            count(*) as `count`
        from ecoli_data
    ) as ed2 on 1=1
) as A
order by A.id