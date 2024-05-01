#!/bin/bash
echo "-------------------------------------------------------" >> __DEPLOY_LOG__
echo " V A L I D A T E  S E R V I C E                        " >> __DEPLOY_LOG__
echo "-------------------------------------------------------" >> __DEPLOY_LOG__

while [ true ]
  do
    if [ "$(curl -s http://localhost:__SERVICE_PORT__/actuator/health)" = '{"status":"UP"}' ]
     then
       echo "/actuator/health STATUS=UP" | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [echo] $_"' >> __DEPLOY_LOG__
       exit 0
    else
       echo "/actuator/health STATUS is not UP or it can't be consulted" | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [echo] $_"' >> __DEPLOY_LOG__
       sleep 3s
    fi
done

echo "-------------------------------------------------------" >> __DEPLOY_LOG__
echo " VALIDATE SERVICE SUCCESS                              " >> __DEPLOY_LOG__
echo "-------------------------------------------------------" >> __DEPLOY_LOG__
