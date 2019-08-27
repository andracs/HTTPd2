# HTTPd2
En webserver, som vi har bygget i klassen DAT 3. semester 2019. 

Sådan virker det: 
- Der etableres en ServerSocket på port 80
- En socket lytter på porten
- Den kan modtage requests som f.eks. __GET /hest.html HTTP/1.1__
- Så vil den indlæse filen /hest.html fra mappen htdocs (hvis ikke den findes, oprettere den et blankt doklument med det navn)
- Filen indlæses linje for linje, og der sendes en repsons på outputstream
- Hver request (inputstream og outputstream) kører i en tråd
