def ClosePopUp

  element = $driver.find_elements :xpath => "//div[@id='TRU-chat-invite']/a[@title='Close Chat Invitation']"
  element2 = $driver.find_elements :xpath => "//div[@class='fsrInvite']/a[@class='fsrCloseBtn']"

    if element.count > 0

      puts('pop-up #2 closed...')
      element[0].click


    end

    if element2.count > 0

      puts('pop-up #1 closed...')
      element2[0].click


    end

end


Then /^I select categories ([^"]*) and ([^"]*)$/ do |x,y|
  ClosePopUp()
  element = $driver.find_element :xpath => "//a[@class = 'mainNavLink' and text()=\"#{x}\"]"
  sleep(1)
  puts('Clicking Age category...')
  ClosePopUp()
  element.click
  sleep(1)
  element = $driver.find_element :xpath => "//div[@class='sliderWrapper']/p/a[text() = \"#{y}\"]"
  sleep(1)
  ClosePopUp()
  element.click
  sleep(1)
  puts('Selected Big Kids subcategory.')
  sleep(1)
end

Then /^I select the Toy/ do
  element = $driver.find_element :xpath => "(//div [@class = 'prodloop-thumbnail']/a/img)[1]"
  sleep(5)
  ClosePopUp()
  element.click
  sleep(5)
  puts('Toy picked.')
  sleep(5)
end

Then /^I select Lego Fusion$/ do
  element = $driver.find_element :xpath => "(//div[@id='tru_category_3']/div[@style]/div[@style]/div[@style]/a/img)[8]"
  sleep(5)
  puts('Locating Lego Fusion...')
  ClosePopUp()
  element.click
  sleep(1)
  puts('Lego Fusion clicked.')
end

Then /^I click ([^"]*)$/ do |x|
  sleep 5
  element = $driver.find_element :id => "#{x}"
  sleep(1)
  ClosePopUp()
  element.click
  puts('Added to Cart.')

end

Then /^I have ([^"]*)$/ do |x|
  sleep(3)
  $driver.find_element :xpath => "//span[@class = 'cartItemCount' and text() = \"#{x}\"]"
  puts('Item verified.')

end

Then /^Click on the ([^"]*) Logo$/ do |x|

element = $driver.find_element :xpath => "//div[@id='hdrWrapper']/div[@id='hdrSection1']/ul/li/a[text()=\"#{x}\"]"
sleep(1)
ClosePopUp()
element.click
puts('Navigating Home....')
end

Then /^I select next categories ([^"]*) and ([^"]*)$/ do |x,y|

sleep(1)
element = $driver.find_element :xpath => "//a[@class = 'mainNavLink' and text()= \"#{x}\"]"
sleep(1)
puts('Clicking Brand...')
ClosePopUp()
element.click
sleep(1)
puts('Locating LEGO...')
element = $driver.find_element :xpath => "//div[@id='trus_shopByModule']/div[@style]/div[@style]/a/img[@alt='#{y}']"
sleep(1)
puts('Clicking LEGO...')
ClosePopUp()
element.click
sleep(1)

end

Then /^Open Cart$/ do
  sleep(5)
  element = $driver.find_element :xpath => "//div[@id='hdrCart']/a[@class='cartButton']"
  puts('Openning Cart...')
  sleep(1)
  ClosePopUp()
  element.click

end

Then /^([^"]*) Items$/ do |x|
  sleep(1)
  element = $driver.find_element :xpath => "//table[@id='cartProductsTable']/tbody/tr/td/ul/li/a[@id='#{x}']"
  puts('Locating remove button....')
  sleep(5)
  ClosePopUp()
  element.click
  puts('Item removed...')

end

Then /^I search for ([^"]*)$/ do |x|
  sleep(1)
  element = $driver.find_element :xpath => "//input[@id='kw']"
  $driver.mouse.move_to element
  puts('Hovering above search bar')
  sleep(5)
  element.send_keys "#{x}"
  puts('input text')

  element = $driver.find_element :xpath => "//input[@id='goButton']"
  sleep(4)
  element.click

end



Then /^Close Driver$/ do
  $driver.execute_script "window.onbeforeunload = function(e){};"
  $driver.quit
  puts('Driver closed!')
  puts(' ')
end

When /^I Navigate to Login$/ do
  sleep 5
  element = $driver.find_element :xpath => "//a[@class='liText']/span[@id='hdrWelcomeLoginText']"
  $driver.mouse.move_to element
  element = $driver.find_element :xpath => "//span[@id='tipcontentText']/a[text() = 'Sign In']"
  element.click
  sleep(2)
end

Then /^Log in$/ do
  element = $driver.find_element :xpath => "//input[@id='emailId']"
  element.send_keys "ilya.rubinshteyn+1@playnext.com"
  sleep(2)
  element = $driver.find_element :xpath => "//input[@id='passwd']"
  element.send_keys "Aeria1234"
  element = $driver.find_element :xpath => "(//input[@alt='Sign In'])[1]"
  element.click
  puts('Logged in.')
##NOTES: Wildcard xpath
##"//*[contains(@class = 'x') and text()='#{y}']"

end


Then /^Close Driver temp$/ do
  $driver.quit

end

Before do
  $driver.get "http://toysrus.com"
end

Then /^I ([^"]*) from my account$/ do |x|
  element = $driver.find_elements :xpath => "//span[@class='loggedIn']"
  if element.count>0
    element[0].click
    element = $driver.find_element :xpath => "//div[@class='tipcontent']/a[text()='#{x}']"
    element.click
    puts('logging out...')
  end
end

Then /^click the ([^"]*) icon$/ do |x|
  element = $driver.find_element :xpath => "//div[@class='#{x}']"
  element.click
end

Then /^switch to new window$/ do
  $driver.switch_to.window $driver.window_handles.last
  sleep 5
  assert $driver.title == 'Pinterest'

end

Then /^close window$/ do
  $driver.close
end


#loops

Then /^Loop1$/ do
  elements = $driver.find_elements :xpath => "//a[@class='results pageNumber']"
  numpages = elements.count-2
  for e in 2..numpages do
    element = $driver.find_element :xpath => "//a[@class='results pageNumber' and text()='#{e}']"
    element.click
    puts "#{e}"
  end

end


