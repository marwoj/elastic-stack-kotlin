#Before:
#sudo apt-get install jq
INPUT=''

while true
do
 IFS= read -rsn1 char
 INPUT=$INPUT$char
 echo
 echo $INPUT
 curl --silent --request GET 'http://localhost:9200/autocomplete/_search' \
 -H "Content-Type: application/json" \
 --data-raw '{
     "size": 5,
     "query": {
         "multi_match": {
             "query": "'"$INPUT"'",
             "type": "bool_prefix",
             "fields": [
                 "title",
                 "title._2gram",
                 "title._3gram"
             ]
         }
     }
 }' | jq .hits.hits[]._source.title | grep -i "$INPUT"
 done
