describe('My First Test', () => {
  it('Does not do much!', () => {
    expect(true).to.equal(true)
  })
})

describe('My App Test', () => {
  it('Visits the app', () => {
    cy.visit('/')
  })

  it('finds the content "Service"', () => {
    cy.visit('/')

    cy.contains('Service')
  })

    it('clicks the link "Ironing"', () => {
      cy.visit('/')
  
      cy.contains('Ironing').click()
    })
})

// describe('My Second Test', () => {
//   it('Does not do much!', () => {
//     expect(true).to.equal(false)
//   })
// })