def solution(id_list, report, k):
    answer = []
    result = []
    dict = {x:[[],0,0] for x in id_list}
    for i in set(report):
        dict[i.split()[0]][0].append(i.split()[1])
        dict[i.split()[1]][1] += 1
        
    for j in id_list:
        if dict[j][1] >= k:
            answer.append(j)
    for i in id_list:
        for j in answer:
            if j in dict[i][0]:
                dict[i][2] += 1
        result.append(dict[i][2])
    
    return result