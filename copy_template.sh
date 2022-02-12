#!/bin/sh

# todo. check file input
# todo. option? leetcode, boj
# todo. user interaction?

SRC_BASE='./src/main'
TEST_BASE='./src/test'

#LEETCODE_SRC_BASE=$SRC_BASE/leetcode
#LEETCODE_TEST_BASE=$TEST_BASE/


FILE_NAME=$1
cp "${SRC_BASE}/java/leetcode/LC_N_Title.java" "${SRC_BASE}/java/leetcode/LC_${FILE_NAME}.java"
cp "${TEST_BASE}/kotlin/leetcode/LC_N_Titletest.kt" "${TEST_BASE}/kotlin/leetcode/LC_${FILE_NAME}Test.kt"