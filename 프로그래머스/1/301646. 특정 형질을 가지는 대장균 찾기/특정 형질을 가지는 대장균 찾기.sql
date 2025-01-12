-- 코드를 작성해주세요
select count(*) as `count` from ecoli_data where genotype = 1 or bin(genotype) & 2 = 0 and (bin(genotype) & 1 > 0 or bin(genotype) & 4 > 0)