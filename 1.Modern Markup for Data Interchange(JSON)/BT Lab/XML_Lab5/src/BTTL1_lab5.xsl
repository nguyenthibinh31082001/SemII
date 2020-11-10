<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTTL1_lab5.xsl
    Created on : August 21, 2020, 3:08 PM
    Author     : ADMIN
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
                <title>BTTL1_lab5.xsl</title>
            </head>
            <body>
                <table border="1" width="400px" style="margin:auto">
                    <tr bgcolor="#9acd32">
                        <th style="text-align:center">Sân</th>
                        <th style="text-align:center">Ngày</th>
                        <th style="text-align:center">Đội 1</th>
                        <th style="text-align:center">Số BT</th>
                        <th style="text-align:center">Đội 2</th>
                        <th style="text-align:center">Số BT2</th>
                    </tr>
                    <xsl:for-each select="FootBall/foot">
                        <tr>
                            <td style="text-align:center">
                                <xsl:value-of select="san"/>
                            </td>
                            <td style="text-align:center"> 
                                <xsl:value-of select="ngay"/>
                            </td>
                            <td style="text-align:center"> 
                                <xsl:value-of select="doi1"/>
                            </td>
                            <td style="text-align:center">
                                <xsl:value-of select="soBT"/>
                            </td>
                            <td style="text-align:center"> 
                                <xsl:value-of select="doi2"/>
                            </td>
                            <td style="text-align:center"> 
                                <xsl:value-of select="soBT2"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
