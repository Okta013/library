--liquibase formatted sql
--changeset Anikeeva:20250119-10-create-transactions

insert into transactions values('9bbeda87-93d7-41f4-8ca2-39407c94b9f1', 'TAKING', '2024-01-15T15:00:32', '25564ef4-d5bf-4319-b3e7-95a9ab743528', '1174f796-7bc3-436c-9e3c-613141c3d8c8');
insert into transactions values('24f962e0-e3f5-41b3-b776-53085b5b1eb9', 'TAKING', '2024-01-19T09:13:58', '86e12755-de66-4fcd-9711-c35964fc9f60', '1cbe27f4-7432-416b-8b34-d3e0931b4df8');
insert into transactions values('236837ef-f7f5-4b23-98bf-cc7df3f95ef2', 'TAKING', '2024-01-28T15:09:36', '5ba1abd4-c88d-4c89-972f-c60b9ca47e07', '070b102a-ab2d-4088-9a11-1bfa0784d2bf');
insert into transactions values('86be73b2-53eb-4900-987d-ecadd9a93132', 'TAKING', '2024-02-04T10:27:16', '25564ef4-d5bf-4319-b3e7-95a9ab743528', '6017e107-0e7f-4605-85f2-cbd832cd1ce4');
insert into transactions values('ea084b94-8318-455e-bcc0-0348a8a8d141', 'RETURNING', '2024-02-11T13:57:02', '86e12755-de66-4fcd-9711-c35964fc9f60', '1cbe27f4-7432-416b-8b34-d3e0931b4df8');
insert into transactions values('4df25b61-ee4a-454e-aad3-72aa506d032c', 'TAKING', '2024-02-15T11:14:27', '1323316b-8d7b-43b6-a94c-e4b0a32a13fe', '2b188ca2-0a5f-4990-855c-5933455665a9');
insert into transactions values('e5d82d37-7993-439d-8b13-feee3f3e5f17', 'RETURNING', '2024-02-23T16:24:06', '1323316b-8d7b-43b6-a94c-e4b0a32a13fe', '2b188ca2-0a5f-4990-855c-5933455665a9');
insert into transactions values('fff09cef-ce60-4dac-b683-05a4d7774c39', 'TAKING', '2024-02-27T18:14:07', '25564ef4-d5bf-4319-b3e7-95a9ab743528', '054b2f15-5ec0-45fd-8535-1d3c984697aa');
insert into transactions values('8003a4d4-7b1e-4d01-bcdd-1e733d945463', 'TAKING', '2024-03-01T15:22:28', '5ba1abd4-c88d-4c89-972f-c60b9ca47e07', '3b56bcc3-6895-4a2e-8dc9-1b38e2b43d33');
insert into transactions values('fc0f5d50-095e-4ba7-a471-88e4909ea0f7', 'RETURNING', '2024-03-12T10:48:04', '5ba1abd4-c88d-4c89-972f-c60b9ca47e07', '3b56bcc3-6895-4a2e-8dc9-1b38e2b43d33')