#!/bin/bash
echo "-------------------------------------------------------" >> __DEPLOY_LOG__
echo " A P P L I C A T I O N  S T A R T                      " >> __DEPLOY_LOG__
echo "-------------------------------------------------------" >> __DEPLOY_LOG__

# run service in port=__SERVICE_PORT__
cd __DEPLOY_DIR__
pwd | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [pwd] $_"' >> __DEPLOY_LOG__
ls | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [ls] $_"' >> __DEPLOY_LOG__
if [ -f '__SERVICE_NAME__.jar' ]
then
    sudo java -jar -Dserver.port=__SERVICE_PORT__ __SERVICE_NAME__.jar > /dev/null 2> /dev/null < /dev/null &
    echo "service is deployed, check log" | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [echo] $_"' >> __DEPLOY_LOG__
else
   echo "no service to deploy with that name" | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [echo] $_"' >> __DEPLOY_LOG__
fi

echo "-------------------------------------------------------" >> __DEPLOY_LOG__
echo " APPLICATION START SUCCESS                             " >> __DEPLOY_LOG__
echo "-------------------------------------------------------" >> __DEPLOY_LOG__
