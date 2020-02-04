cmake_minimum_required(VERSION 3.14)
project(algorithms_cpp)

set(CMAKE_CXX_STANDARD 14)

set(googleTestDir ./googletest)

add_subdirectory(${googleTestDir})
include_directories(${googleTestDir}/googletest/include)
include_directories(${googleTestDir}/googlemock/include)

include_directories(./include)

add_executable(algorithms_cpp src/permutation.cpp test/permutation_test.cpp include/permutation.h)

# Link with GoogleTest
target_link_libraries(algorithms_cpp gtest gtest_main)
#Link with GoogleMock
target_link_libraries(algorithms_cpp gmock gmock_main)
