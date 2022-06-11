echo "Checking if hub is ready - $HUB_HOST"


# shellcheck disable=SC1073
while [[ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready)" != "true" ]]; do
  sleep 1
  done


  java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE