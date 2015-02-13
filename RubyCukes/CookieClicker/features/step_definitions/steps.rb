def ClickLoop
  while
    driver=$driver do
    cookie = driver.find_element :xpath => "//div[@id='bigCookie']"
    cookie.click

  end
end



#Load Cookie Clicker
Then /^Start Driver$/ do
  $driver.get "http://orteil.dashnet.org/cookieclicker/"
  puts('Started Driver.')
end

#Click Big Cookie
#Then /^Click the (^")*$/ do |x|

Then  /^Click bigCookie$/  do
  ClickLoop()

end

#close WebDriver
Then /^Close Driver$/ do
  $driver.execute_script "window.onbeforeunload = function(e){};"
  sleep(4)
  puts('Driver closed!')
  $driver.quit

end

