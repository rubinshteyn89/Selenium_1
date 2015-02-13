require 'rubygems'
require 'selenium-webdriver'
require 'cucumber'


$driver = Selenium::WebDriver.for :chrome
Selenium::WebDriver::Chrome::Service.executable_path = '/usr/local/bin/chromedriver'
