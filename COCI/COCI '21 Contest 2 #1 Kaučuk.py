sectionNum = subsectionNum = subsubsectionNum = 0

for i in range(int(input())):
   sectionType, title = temp = input().split()

   if sectionType == 'section':
      subsectionNum = subsubsectionNum = 0
      sectionNum += 1
      print(f"{sectionNum} {title}")
   elif sectionType == 'subsection':
      subsubsectionNum = 0
      subsectionNum += 1
      print(f"{sectionNum}.{subsectionNum} {title}")
   else:
      subsubsectionNum += 1
      print(f"{sectionNum}.{subsectionNum}.{subsubsectionNum} {title}")
