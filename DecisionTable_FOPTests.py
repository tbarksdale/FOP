import unittest
from unittest import TestCase

import pytest
import http_requests

webapp_endpoint = "www.fop.com"

username = {"username1": "Tim Barksdale"}

""" Assume this is a FOP web service that accepts posts for username strings and for answers to each question """

@pytest.fixture()
def url_http():
    return host('webapp_endpoint', scheme='http')

@pytest.fixture()
def assert_equal(is_value, expect_value):
        assert is_value == expect_value, str(is_value) + " != " + str(expect_value)

@pytest.fixture()
def expect_ok(response):
    assert response.status_code == 200, "Response status_code {0} != 200\nResponse reason: {1}\nResponse text: {2}".format(
        str(response.status_code), response.reason.encode('utf-8'), response.text.encode('utf-8'))

class FOPTests(unittest.TestCase):
    """
    All tests in this class
    """
    def test1_end_to_end_successful_ent_client(self):

        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username1'] = self.username[0]
        response = http_requests.post(url_http() + "username", data=username)
        assert response.json()["is_successful"], response.json()

        """ First answer if enterprise or platinum"""

        response = http_requests.post(url_http(), data=EntClientChoice)
        assert response.status_code == 200

        """ Next answer yes to the checking account question"""

        response = http_requests.post(url_http(), data=CheckingAcctYES)
        assert response.status_code == 200

        """ Next question is if the customer has $200, 000 or more in deposits """

        response = http_requests.post(url_http(), data=DepositsYES)
        assert response.status_code == 200

        """ Next question is - does the customer already have overdraft protection? """
        """ For this test answer NO"""

        response = http_requests.post(url_http(), data=OverdraftProtectionNO)
        assert response.status_code == 200

        """ and final question is - does the customer have fewer than five overdrafts in the last 12 months? """

        response = http_requests.post(url_http(), data=OverdraftFewerYES)
        assert response.status_code == 200

        """ Post a submit and verify success message"""
        response = http_requests.post(url_http(), data=submit)
        assert response.json()["You have been approved for Free Overdraft Protection."], response.json()


    def test2_end_to_end_successful_platinum_client(self):
        """
        Navigate to a web page
        """
        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username1'] = self.username[0]
        response = http_requests.post(url_http() + "username", headers=None, data=username)
        assert response.json()["is_successful"], response.json()

        """ First answer if enterprise or platinum"""

        response = http_requests.post(url_http(), data=PlatinumClientChoice)
        assert response.status_code == 200

        """ Next answer yes to the checking account question"""

        response = http_requests.post(url_http(), data=CheckingAcctYES)
        assert response.status_code == 200

        """ Next question is if the customer has $200, 000 or more in deposits """

        response = http_requests.post(url_http(), data=DepositsYES)
        assert response.status_code == 200

        """ Next question is - does the customer already have overdraft protection? """
        """ For this test answer NO"""

        response = http_requests.post(url_http(), data=OverdraftProtectionNO)
        assert response.status_code == 200

        """ and final question is - does the customer have fewer than five overdrafts in the last 12 months? """

        response = http_requests.post(url_http(), data=OverdraftFewerYES)
        assert response.status_code == 200

        """ Post a submit and verify success message"""
        response = http_requests.post(url_http(), data=submit)
        assert response.json()["You have been approved for Free Overdraft Protection."], response.json()



    def test3_already_have_fop(self):
        """
        Navigate to a web page
        """
        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username1'] = self.username[0]
        response = http_requests.post(url_http() + "username", headers=None, data=username)
        assert response.json()["is_successful"], response.json()

        """ First answer if enterprise or platinum"""

        response = http_requests.post(url_http(), data=EntClientChoice)
        assert response.status_code == 200

        """ Next answer yes to the checking account question"""

        response = http_requests.post(url_http(), data=CheckingAcctYES)
        assert response.status_code == 200

        """ Next question is if the customer has $200, 000 or more in deposits """

        response = http_requests.post(url_http(), data=DepositsYES)
        assert response.status_code == 200

        """ Next question is - does the customer already have overdraft protection? """
        """ For this test answer YES"""

        response = http_requests.post(url_http(), data=OverdraftProtectionYES)
        assert response.json()["Free Overdraft Protection Denied."], response.json()


    def test4_no_checking(self):
        """
        Navigate to a web page
        """
        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username1'] = self.username[0]
        response = http_requests.post(url_http() + "username", headers=None, data=username)
        assert response.json()["is_successful"], response.json()

        """ First answer if enterprise or platinum"""

        response = http_requests.post(url_http(), data=EntClientChoice)
        assert response.status_code == 200

        """ Next answer NO to the checking account question for this test"""

        response = http_requests.post(url_http(), data=CheckingAcctNO)
        assert response.json()["Free Overdraft Protection Denied."], response.json()


    def test5_not_enough_deposits(self):
        """
        Navigate to a web page
        """
        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username1'] = self.username[0]
        response = http_requests.post(url_http() + "username", headers=None, data=username)
        assert response.json()["is_successful"], response.json()

        """ First answer if enterprise or platinum"""

        response = http_requests.post(url_http(), data=PlatinumClientChoice)
        assert response.status_code == 200

        """ Next answer yes to the checking account question"""

        response = http_requests.post(url_http(), data=CheckingAcctYES)
        assert response.status_code == 200

        """ Next question is if the customer has $200, 000 or more in deposits, for this test answer NO """

        response = http_requests.post(url_http(), data=DepositsNO)
        assert response.json()["Free Overdraft Protection Denied."], response.json()


    def test6_more_than_five_overdrafts(self):
        """
        Navigate to a web page
        """
        response = http_requests.get(url_http(), allow_redirects=True)
        expect_ok(response)
        assert "Welcome to FOP" in response.text

        username['username1'] = self.username[0]
        response = http_requests.post(url_http() + "username", headers=None, data=username)
        assert response.json()["is_successful"], response.json()

        """ First answer if enterprise or platinum"""

        response = http_requests.post(url_http(), data=EntClientChoice)
        assert response.status_code == 200

        """ Next answer yes to the checking account question"""

        response = http_requests.post(url_http(), data=CheckingAcctYES)
        assert response.status_code == 200

        """ Next question is if the customer has $200, 000 or more in deposits """

        response = http_requests.post(url_http(), data=DepositsYES)
        assert response.status_code == 200

        """ Next question is - does the customer already have overdraft protection? """
        """ For this test answer NO"""

        response = http_requests.post(url_http(), data=OverdraftProtectionNO)
        assert response.status_code == 200

        """ and final question is - does the customer have fewer than five overdrafts in the last 12 months? """
        """ for this test answer NO"""

        response = http_requests.post(url_http(), data=OverdraftFewerNO)
        assert response.json()["Free Overdraft Protection Denied."], response.json()