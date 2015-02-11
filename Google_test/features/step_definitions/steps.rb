Given /^I have Google open$/ do

  $driver.get "https://www.google.com/"
  sleep 1
end

When /^I click on the Search Field and input "([^"]*)"$/ do |x|
  element = $driver.find_element :xpath => "//input[@name='q']"
  sleep 1
  $driver.mouse.move_to element
  sleep 1
  element.click
  sleep 1
  element.send_keys "#{x}"
  sleep 1
end

And /^I click the search button$/ do
  element = $driver.find_element :xpath => "//button[@name='btnG']"
  sleep 1
  element.click
  sleep 1
end

Then /^I can click on the first search result$/ do
  element = $driver.find_element :xpath => "(//h3[@class='r'])[1]"
  sleep 1
  element.click

end


Before do
  $driver.get "https://www.google.com/"
end

After do
  $driver.quit
end

