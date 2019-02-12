#!/bin/sh
echo "进来了"
if [ ! -d logs  ];then
  mkdir logs
else
  echo dir exist
fi

if [ ! -d logs/start.log  ];then
  touch logs/start.log
else
  echo file exist
fi


oldId=`ps -ef | grep wx-learn | grep -v grep | awk '{print $2}'`
echo "杀死原有进程"
echo $oldId
kill $oldId

echo "启动"
cd target && java -jar wx-learn-0.0.1-SNAPSHOT.jar >> ../logs/start.log 2>&1 &
oldId=`ps -ef | grep wx-learn | grep -v grep | awk '{print $2}'`
echo $oldId