#!/bin/bash
echo "-------------------------------------------------------" >> __DEPLOY_LOG__
echo " B E F O R E  I N S T A L L                            " >> __DEPLOY_LOG__
echo "-------------------------------------------------------" >> __DEPLOY_LOG__

# terminate java process
process=`ps -ef | grep -v awk | awk -e '/java.*__SERVICE_NAME__.jar/ { print $2 }'`
if [ -z "$process" ]
then
    echo "no process to terminate" | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [echo] $_"' >> __DEPLOY_LOG__
else
      echo "terminating process ${process}" | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [echo] $_"' >> __DEPLOY_LOG__
      sudo kill -TERM ${process} | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [kill] $_"' >> __DEPLOY_LOG__
fi

# remove jar file
cd __DEPLOY_DIR__
pwd | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [pwd] $_"' >> __DEPLOY_LOG__
ls | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [ls] $_"' >> __DEPLOY_LOG__
if [ -f '__SERVICE_NAME__.jar' ]
then
    sudo rm -v -f __SERVICE_NAME__.jar | perl -MPOSIX -ne 'BEGIN{ $|=1 } print strftime( "%Y-%m-%d %H:%M:%S", localtime ) . " [rm] $_"' | sudo tee -a __DEPLOY_LOG__
fi

echo "-------------------------------------------------------" >> __DEPLOY_LOG__
echo " BEFORE INSTALL SUCCESS                                " >> __DEPLOY_LOG__
echo "-------------------------------------------------------" >> __DEPLOY_LOG__
