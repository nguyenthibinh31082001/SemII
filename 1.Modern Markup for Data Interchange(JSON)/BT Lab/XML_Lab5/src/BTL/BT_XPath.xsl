<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BT_XPath.xsl
    Created on : August 22, 2020, 7:43 PM
    Author     : Admin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>BT_XPath.xsl</title>
            </head>
            <body style="text-align:center">
               <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2 >Các nhân viên Việt Nam:</h2>
                    <tr>
                        <th scope="col">Họ</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Giới tính</th>
                        <th scope="col">Ngày sinh</th>
                        <th scope="col">Công ty</th>
                    </tr>
                    <xsl:for-each select="/Employees/Employee">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <!-- lấy các nhân viên ở Việt nam.-->
                        <xsl:if test="Company[@country = 'Viet Nam']">
                        <tr>
                            <td>
                            <xsl:value-of select="Name/LastName" />
                            </td>
                            <td>
                                <xsl:value-of select="Name/FirstName" />
                            </td>
                            <td>
                                <xsl:value-of select="Gender" />
                            </td>
                            <td>
                                <xsl:value-of select="Birthday" />
                            </td>
                            <td>
                                <xsl:value-of select="Company" />
                            </td>
                        </tr>
                       </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2>Các nhân viên nước ngoài:</h2>
                    <tr>
                        <th scope="col">Họ</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Giới tính</th>
                        <th scope="col">Ngày sinh</th>
                        <th scope="col">Công ty</th>
                    </tr>
                    <xsl:for-each select="/Employees/Employee">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <!-- lấy các nhân viên ở Việt nam.-->
                        <xsl:if test="Company[@country != 'Viet Nam']">
                        <tr>
                            <td>
                            <xsl:value-of select="Name/LastName" />
                            </td>
                            <td>
                                <xsl:value-of select="Name/FirstName" />
                            </td>
                            <td>
                                <xsl:value-of select="Gender" />
                            </td>
                            <td>
                                <xsl:value-of select="Birthday" />
                            </td>
                            <td>
                                <xsl:value-of select="Company" />
                            </td>
                        </tr>
                       </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2>Các nhân viên có năm sinh từ 1995 tới nay:</h2>
                    <tr>
                        <th scope="col">Họ</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Giới tính</th>
                        <th scope="col">Ngày sinh</th>
                        <th scope="col">Công ty</th>
                    </tr>
                    <xsl:for-each select="/Employees/Employee">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <!-- lấy các nhân viên ở Việt nam.-->
                        <xsl:if test="Birthday[@year >= 1995]">
                        <tr>
                            <td>
                            <xsl:value-of select="Name/LastName" />
                            </td>
                            <td>
                                <xsl:value-of select="Name/FirstName" />
                            </td>
                            <td>
                                <xsl:value-of select="Gender" />
                            </td>
                            <td>
                                <xsl:value-of select="Birthday" />
                            </td>
                            <td>
                                <xsl:value-of select="Company" />
                            </td>
                        </tr>
                       </xsl:if>
                    </xsl:for-each>
                </table>
                <table border="1" width="500px" style="margin:auto; text-align:center">
                    <h2>Các công ty ở nước ngoài được đánh dấu:</h2>
                    <tr>
                        <th scope="col">Họ</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Giới tính</th>
                        <th scope="col">Ngày sinh</th>
                        <th scope="col">Công ty</th>
                    </tr>
                    <xsl:for-each select="/Employees/Employee">
                        <!-- sắp xếp tên sách theo thứ tự alphabel.-->
                        <xsl:sort data-type="text" select="Name/FirstName" order="descending" />
                        <tr>
                            <td>
                            <xsl:value-of select="Name/LastName" />
                            </td>
                            <td>
                                <xsl:value-of select="Name/FirstName" />
                            </td>
                            <td>
                                <xsl:value-of select="Gender" />
                            </td>
                            <td>
                                <xsl:value-of select="Birthday" />
                            </td>
                            <xsl:if test="Company[@country != 'Viet Nam']">
                            <td  style=" background-color:#ff8080">
                                <xsl:value-of select="Company"/>
                            </td>
                            </xsl:if>
                            <xsl:if test="Company[@country = 'Viet Nam']">
                            <td>
                                <xsl:value-of select="Company"/>
                            </td>
                            </xsl:if>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
