-- 코드를 작성해주세요
select
    ed2.id,
    ed2.genotype,
    ed1.genotype as `parent_genotype`
from ecoli_data ed1
join ecoli_data ed2 on ed1.id = ed2.parent_id and ed1.genotype & ed2.genotype = ed1.genotype