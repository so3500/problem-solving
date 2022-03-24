#!/bin/sh

# todo. check file input
# todo. option? leetcode, boj
# todo. user interaction?

SRC_BASE='./src/main'
TEST_BASE='./src/test'

#LEETCODE_SRC_BASE=$SRC_BASE/leetcode
#LEETCODE_TEST_BASE=$TEST_BASE/


INPUT_NAME=$1

CLASS_NAME=LC_${INPUT_NAME}
TEST_CLASS_NAME=LC_${INPUT_NAME}Test
CLASS_FILE_NAME=${CLASS_NAME}.java
TEST_CLASS_FILE_NAME=${TEST_CLASS_NAME}.kt

cp ${SRC_BASE}/java/leetcode/LC_N_Title.java ${SRC_BASE}/java/leetcode/${CLASS_FILE_NAME}
cp ${TEST_BASE}/kotlin/leetcode/LC_N_TitleTest.kt ${TEST_BASE}/kotlin/leetcode/${TEST_CLASS_FILE_NAME}

sed -i '' "s/LC_N_Title/${CLASS_NAME}/g" ${SRC_BASE}/java/leetcode/${CLASS_FILE_NAME}
sed -i '' "s/LC_N_TitleTest/${TEST_CLASS_NAME}/g" ${TEST_BASE}/kotlin/leetcode/${TEST_CLASS_FILE_NAME}
sed -i '' "s/LC_N_Title/${CLASS_NAME}/g" ${TEST_BASE}/kotlin/leetcode/${TEST_CLASS_FILE_NAME}

# refs
# https://stackoverflow.com/q/21228347